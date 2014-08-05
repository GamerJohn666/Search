/**
 *  格式化时间
 */
Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
	// millisecond
	}
	if (/(y+)/.test(format))
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(format))
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
	return format;
};

/**
 * 共同ajax调用
 * 
 * @param options
 *            是一个自定义对象属性有 data:提交参数信息 url:请交路径 reloadTable:要刷新的表格名称
 *            callBackFun:回调函数
 */
function sendAjaxRequest(options) {
	$.ajax({
		async : false,
		cache : false,
		type : "POST",
		dataType : "json",
		data : options.data,
		url : options.url,// 请求的action路径
		error : function(date) {// 请求失败处理函数
			alert('请求失败');
		},
		success : function(data) {
				// 当自定义回调函数为null时，调用默认函数处理
			
			options.callBackFun(data);

		}
	});
}

