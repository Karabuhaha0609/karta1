requirejs.config({
    baseUrl: 'js'
})


function buildRoute(view) {
    return function() {
        webix.ui({
            id: 'root',
            rows: [
                view
            ]
        }, $$('root'))
    }
}

function buildButton(label, route) {
    return {
        view: 'button',
        value: label,
        width: 100,
        align: 'center',
        click: function() {
            routie(route)
        }
    }
}

require(
    [
    'views/main',
    'views/mark/markList',
    'views/grafik/grafikList',
    'views/model/modelList',
    'views/voditelWeb/voditelWebList',
    'util/resourceProxy'
    ],
    function(main, marks, grafiks,  models, voditelWebs, resourceProxy) {
    webix.ready(function() {
        webix.ui({
            container: 'app',
            width: document.body.clientWidth,
            height: document.body.clientHeight,
            rows: [
                {
                    view: 'toolbar',
                    cols: [
                        buildButton('Home', ''),
                        buildButton('Марки', 'marks'),
                        buildButton('Модели', 'models'),
                        buildButton('График', 'grafiks'),
                        buildButton('Водители', 'voditelWebs')
                    ]
                },
                {
                    id: 'root'
                }
            ]
        })
    })

    routie({
        '': buildRoute(main),
        'marks': buildRoute(marks),
        'models': buildRoute(models),
        'grafiks': buildRoute(grafiks),
        'voditelWebs': buildRoute(voditelWebs)
    })


})
