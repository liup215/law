/**
 * 初始化财务详情对话框
 */
var MoneyInfoDlg = {
    moneyInfoData : {}
};

/**
 * 清除数据
 */
MoneyInfoDlg.clearData = function() {
    this.moneyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MoneyInfoDlg.set = function(key, val) {
    this.moneyInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MoneyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
MoneyInfoDlg.close = function() {
    parent.layer.close(window.parent.Money.layerIndex);
}

/**
 * 收集数据
 */
MoneyInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
MoneyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/money/add", function(data){
        Feng.success("添加成功!");
        window.parent.Money.table.refresh();
        MoneyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.moneyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
MoneyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/money/update", function(data){
        Feng.success("修改成功!");
        window.parent.Money.table.refresh();
        MoneyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.moneyInfoData);
    ajax.start();
}

$(function() {

});
