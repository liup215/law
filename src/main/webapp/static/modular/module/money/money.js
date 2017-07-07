/**
 * 财务管理初始化
 */
var Money = {
    id: "MoneyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Money.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Money.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Money.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加财务
 */
Money.openAddMoney = function () {
    var index = layer.open({
        type: 2,
        title: '添加财务',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/money/money_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看财务详情
 */
Money.openMoneyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '财务详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/money/money_update/' + Money.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除财务
 */
Money.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/money/delete", function (data) {
            Feng.success("删除成功!");
            Money.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("moneyId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询财务列表
 */
Money.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Money.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Money.initColumn();
    var table = new BSTable(Money.id, "/money/list", defaultColunms);
    table.setPaginationType("client");
    Money.table = table.init();
});
