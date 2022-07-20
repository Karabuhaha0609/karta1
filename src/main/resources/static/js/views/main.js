define(function() {
    return {
        type: "line",
        height: 300,
        rows: [
            {
                view: 'button',
                label: 'Main',
                click: function() {
                    routie('main')
                }
            },
            { template: "Row 1" },
            { template: "Row 2" },

        ]
    }
});
