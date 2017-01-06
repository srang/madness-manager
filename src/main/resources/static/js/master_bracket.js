$(document).ready(function () {
    var teamMap = $.map(teams, function (obj) {
        obj.id = obj.teamId;
        obj.text = obj.name;
        return obj;
    });
    // initialize all tooltips
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    $('#start-madness').on('click', function () {
        console.log("let the fun begin");
        $('#madness-flag').val('true');
        $('#save-button').click();
    });

    $(window).keydown(function (event) {
        if (event.keyCode == 13) {
            event.preventDefault();
            return true;
        }
    });
    function format(item) {
        return item.name;
    };


    $('label.master-label').on('click', function () {
        $(this).addClass('hide');
        var input = $('select.master-input[id=' + $(this).attr('for') + ']');
        input.removeClass('hide');
        input.select2({
            placeholder: "select a team",
            data: teamMap,
            formatSelection: format,
            formatResult: format
        });

        // input.typeahead({
        //         minLength: 1,
        //         highlight: true
        // },
        // {
        //     name: 'team-dataset',
        //     display: 'name',
        //     source: searchTeams,f
        //     templates: {
        //         empty: [
        //             '<div class="typeahead-result">',
        //             'No Results',
        //             '</div>'
        //                 ].join('\n'),
        //         suggestion : function (val) {
        //                     return '<p class="typeahead-result" data-value="' + val.team_id + '">' + val.name + '</p>';
        //                 }
        //     }
        // });
        // input.on('select', function(event, selection) {
        //     $(this).typeahead('val',selection.name);
        //     $(this).typeahead('destroy');
        //     $(this).val(selection.name);
        //     $(this).addClass('hide');
        //     var label = $('label.master-label[for='+$(this).attr('id')+']');
        //     label.text(selection.name);
        //     label.removeClass('hide');
        //     label.addClass('unsaved');
        // });
        //
        // input.on('blur', function() {
        //     $(this).typeahead('val','');
        //     $(this).typeahead('destroy');
        //     $(this).addClass('hide');
        //     var label = $('label.master-label[for='+$(this).attr('id')+']');
        //     label.removeClass('hide');
        // });
    });

});
