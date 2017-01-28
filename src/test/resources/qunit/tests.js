/**
 * Created by srang on 1/21/17.
 */
QUnit.test( "test-parseGameId", function( assert ) {
    var testId = "G-0-0-A";
    var result = __parseGameId(testId);
    assert.deepEqual( result, {
            round: '0',
            game: '0',
            team: 'A'});
});

QUnit.test( "test-getParentId", function( assert ) {
    var testId = "G-0-1-A";
    var result = __getParentId(testId);
    assert.equal( result, "G-1-1-A");
    testId = "G-0-1-B";
    result = __getParentId(testId);
    assert.equal( result, "G-1-1-A");
    testId = "G-0-3-A";
    result = __getParentId(testId);
    assert.equal( result, "G-1-2-A");

    testId = "G-0-2-B";
    result = __getParentId(testId);
    assert.equal( result, "G-1-1-B");

    testId = "G-0-11-A";
    result = __getParentId(testId);
    assert.equal( result, "G-1-6-A");
});