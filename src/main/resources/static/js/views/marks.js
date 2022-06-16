define(['component/listPage'], function(listPage) {
    return listPage(
                    'markList',
                    'resource->/index/api/mark',
                 [
                 { id:"name", editor:"text"},
                 ])
})