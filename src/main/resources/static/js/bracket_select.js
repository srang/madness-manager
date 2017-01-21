/**
 * credit to Craig Buckler
 * http://www.sitepoint.com/javascript-generate-lighter-darker-color/
 * changes hex color luminosity
 */
function _changeColorIntensity(hex, lum) {
    // validate hex string
    hex = String(hex).replace(/[^0-9a-f]/gi, '');
    if (hex.length < 6) {
        hex = hex[0] + hex[0] + hex[1] + hex[1] + hex[2] + hex[2];
    }
    lum = lum || 0;

    // convert to decimal and change luminosity
    var rgb = "", c, i;
    for (i = 0; i < 3; i++) {
        c = parseInt(hex.substr(i * 2, 2), 16);
        c = Math.round(Math.min(Math.max(0, c + (c * lum)), 255)).toString(16);
        rgb += ("00" + c).substr(c.length);
    }
    return rgb;
}

function __setButtonColors(button, primary, accent) {
    button.css('background-color', "#" + primary);
    button.css('color', "#" + accent);
}

function __gameIndex(itemId) {
    return itemId.match(/[0-9]+-[AB]/)[0].match(/[0-9]+/)[0];
}

function __team(itemId) {
    return itemId.match(/[AB]/)[0];
}

function __round(itemId) {
    return itemId.match(/G-[0-9]+/)[0].match(/[0-9]+/)[0];
}

function __getParentId(childId) {
    // id = G-<round>-<game_index>-A/B
    var letters = {1: 'A', 2: 'B'};
    var round = parseInt(__round(childId));
    var game = parseInt(__gameIndex(childId));
    round = round + 1;
    var team = letters[(game-1) % 2 + 1];
    game = Math.ceil(game / 2);
    var parentId = 'G-' + round.toString() + '-' + game.toString() + '-' + team;
    return parentId;
}

function __parseGameId(gameId) {
    // id = R<round>G<game>T<team>(B) when button
    var round = __round(gameId);
    var game = __gameIndex(gameId);
    var team = __team(gameId);
    var ret = {
        "round": round,
        "game": game,
        "team": team
    };
    return ret;
}

function _getGameInfo(game) {
    var info = __parseGameId(game.data('id'));
    info.name = game.find('.team-name').text();
    return info;
}

function _getTeamInfo(team) {
    var t = teams[team.data('teamid')];
    if (!t) { return null; }
    // var t = $('#'+_teamEncode($('#'+team.attr('id').slice(0,-1)).val()));
    // find input for game, return winner.val
    var info = __parseGameId(team.data('id'));
    var name = t.name;
    // also want to pass team colors and rank

    var primaryColor = t['primaryColor'];
    var accentColor = t['accentColor'];
    var rank = '#' + t['rank'];
    return {
        "teamid": t.teamId,
        "name": name,
        "rank": rank,
        "primary": primaryColor,
        "accent": accentColor
    };
}

function _updateGames(parent, winner, loser) {
    // save old value in case gets unset
    // var old = parent['label'].text();
    // parent['button'].data('teamid', old);

    // set button text
    var winnerInfo = _getTeamInfo(winner);
    var loserInfo = _getTeamInfo(loser);
    __setButtonColors(winner, winnerInfo.primary, winnerInfo.accent);
    if (parent['button'][0]) {
        parent['label'].text(winnerInfo.name);
        parent['rank'].text(winnerInfo.rank);
        __setButtonColors(parent['button'], winnerInfo.primary, winnerInfo.accent);
        parent['button'].data('teamid', winnerInfo['teamid']);
    }

    if(loserInfo) {
        __setButtonColors(loser, _changeColorIntensity(loserInfo.primary, -0.6), _changeColorIntensity(loserInfo.accent, -0.6));
    }

    // update hidden input with winner
    parent['input'].val(winnerInfo.teamid);
}

function _unsetWinner(game) {
    $('#' + game.data('id')).val('');
}

function _getParentGame(game) {
    var id = '#' + __getParentId(game.data('id'));
    return {
        'input': $(id),
        'label': $(id + '-name'),
        'rank': $(id + '-rank'),
        'button': $(id + '-name').parent()
    };
}

$('.btn-team').on('click', function () {
    // read game info for button clicked
    var gameInfo = _getGameInfo($(this));
    var loser = $(this).parent().find('.btn-team').not('*[data-id=' + $(this).data('id')+"]");
    var parent = _getParentGame($(this));

    _updateGames(parent, $(this), loser);
});

$('.team-input').each(function () {
    var id = $(this).attr('id');
    var name = $('#' + id + '-name');
    var rank = $('#' + id + '-rank');
    var teamId = $(this).val();
    if (teamId) {
        var team = teams[teamId];
        name.text(team.name);
        rank.text('#' + team.rank);
        var button = name.parent();
        button.data('teamid', teamId);
        __setButtonColors(button, team.primaryColor, team.accentColor);
    } else {
        name.text("TBD");
    }
});

$('#bracket-submit').on('click', function () {
    $('#bracket-submit-actual').click();
});
