define(['component/listPageGrafik', 'collections/voditelWebs', 'js/vremya.js'], function(listPageGrafik, voditelWebs) {
    return listPageGrafik(
                    'grafikList',
                    'resource->/index/api/grafik',
                 [
                                  {
                                     id:'model',
                                     dialogUrl: 'views/model/modelDialog',
                                     template: function(row) {
                                         return row.model && row.model.repr || ''}
                                  },
                                  {id:'dateSmena'},
//                 { id:'voditelWeb', editor: 'combo', options: voditelWebs, header: format(str1) },
                 { id:'pnDay', editor: 'combo', options: voditelWebs, header: str1},
//                 { id:'vtDay', editor: 'combo', options: voditelWebs, header: format(str2) },
//                 { id:'srDay', editor: 'combo', options: voditelWebs, header: format(str3) },
//                 { id:'chtDay', editor: 'combo', options: voditelWebs, header: format(str4) },
//                 { id:'pytDay', editor: 'combo', options: voditelWebs, header: format(str5) },
//                 { id:'sbDay', editor: 'combo', options: voditelWebs, header: format(str6) },
//                 { id:'vsDay', editor: 'combo', options: voditelWebs, header: format(str7) },
                 ],

          )
      });

