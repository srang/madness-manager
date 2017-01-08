$(document).ready(function () {
    var teamMap = $.map(teams, function (obj) {
        obj.id = obj.teamId;
        obj.text = obj.name;
        return obj;
    });
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
    }
    function clear(label, select) {
        select.select2('destroy');
        select.addClass('hide');
        label.removeClass('hide');
    }

    $('label.master-label').on('click', function () {
        $(this).addClass('hide');
        var label = $(this);
        var input = $('select.master-input[id=' + $(this).attr('for') + ']');
        var realInput = $('input[id=' + $(this).attr('for') + '-actual]');
        input.removeClass('hide');
        input.select2({
            placeholder: "select a team",
            data: teamMap,
            formatSelection: format,
            formatResult: format
        });
        input.select2('open');

    });
    $('select.master-input').on('select2:select', function(event) {
        var label = $('label.master-label[for='+$(this).attr('id')+']');
        var realInput = $('input[id=' + $(this).attr('id') + '-actual]');
        label.text(event.params.data.name);
        label.addClass('unsaved');
        realInput.val(event.params.data.id);
    });

    $('select.master-input').on('select2:close', function(event){
        var label = $('label.master-label[for='+$(this).attr('id')+']');
        clear(label, $(this));
    });

});
