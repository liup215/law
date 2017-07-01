package com.hidear.law.core.shiro.factory;

import com.hidear.law.common.constent.factory.ConstantFactory;
import com.hidear.law.common.constent.state.ManagerStatus;
import com.hidear.law.core.util.Convert;
import com.hidear.law.modular.admin.dao.MenuRepository;
import com.hidear.law.modular.admin.dao.RelationRepository;
import com.hidear.law.modular.admin.dao.RoleRepository;
import com.hidear.law.modular.admin.model.Relation;
import com.hidear.law.modular.admin.model.Role;
import com.hidear.law.modular.admin.model.User;
import com.hidear.law.modular.admin.dao.UserRepository;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.util.SpringContextHolder;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/1.
 */
@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactory implements IShiro{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RelationRepository relationRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static IShiro me() {
        return SpringContextHolder.getBean(IShiro.class);
    }

    @Override
    public User user(String account) {

        User user = userRepository.findByAccount(account);

        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        // 账号被冻结
        if (user.getStatus() != ManagerStatus.OK.getCode()) {
            throw new LockedAccountException();
        }
        return user;
    }

    @Override
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();

        shiroUser.setId(user.getId());            // 账号id
        shiroUser.setAccount(user.getAccount());// 账号
        shiroUser.setDeptId(user.getDeptid());    // 部门id
        shiroUser.setDeptName(ConstantFactory.me().getDeptName(user.getDeptid()));// 部门名称
        shiroUser.setName(user.getName());        // 用户名称

        Integer[] roleArray = Convert.toIntArray(user.getRoleid().toString());// 角色集合
        List<Integer> roleList = new ArrayList<Integer>();
        List<String> roleNameList = new ArrayList<String>();
        for (int roleId : roleArray) {
            roleList.add(roleId);
            roleNameList.add(ConstantFactory.me().getSingleRoleName(roleId));
        }
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);

        return shiroUser;
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        Role role = roleRepository.findOne(roleId);
        Relation relation = new Relation();
        relation.setRole(role);
        Example<Relation> example = Example.of(relation);
        List<Relation> relations = relationRepository.findAll(example);
        List<String> resUrls = new ArrayList<>();
        for(Relation item: relations){
            resUrls.add(item.getMenu().getUrl());
        }
        return resUrls;
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        return ConstantFactory.me().getSingleRoleTip(roleId);
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        String credentials = user.getPassword();
        // 密码加盐处理
        String source = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }
}
