define(['component/listPage'], function(listPage) {
    return listPage(
                    'voditelWebList',
                    'resource->/index/api/voditelweb',
                 [
                 { id: "name", editor: "text", header: "Фамилия"},
                 { id: "firstName", editor: "text", header: "Имя"},
                 ]
                 )
})