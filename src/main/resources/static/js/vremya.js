    function format(obj){
      if (obj.value){
        if (webix.isArray(obj.value))
          return obj.value.map(webix.i18n.dateFormatStr).join("<br>");
        return webix.i18n.dateFormatStr( obj.value );
      }
      return "";
    };
    var i1 = {
                      id:"i1", view:"datepicker", value:"2018-1-16"
                    };
                    var t2 = {
                      id:"t2", template:format
                    };


$$("t2").bind($$("i2"), "value");



//webix.Date.startOnMonday = true;
//webix.i18n.setLocale("ru-RU");
//    var format = webix.Date.dateToStr("%D %d.%m");
//var str = new Date().bind($$('i1'), "value");
//$$("str").bind($$("dayday"), "value");

//$$('dayday').getValue();
//str.setValue();
//$$("dayday").getValue();
//$$(str).setValue();
//$$("grafik").bind($$("dayday"));

//var str = $$("dayday");



  var str1 = webix.Date.weekStart(t2);
//  var str2 = webix.Date.add(str1,1,"day",true);
//  var str3 = webix.Date.add(str1,2,"day",true);
//  var str4 = webix.Date.add(str1,3,"day",true);
//  var str5 = webix.Date.add(str1,4,"day",true);
//  var str6 = webix.Date.add(str1,5,"day",true);
//  var str7 = webix.Date.add(str1,6,"day",true);
