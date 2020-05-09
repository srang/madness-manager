var gulp = require('gulp'),
    uglify = require('gulp-uglify'),
    concat = require('gulp-concat'),
    less = require('gulp-less'),
    path = require('path'),
    css = require('gulp-clean-css'),
    notify = require('gulp-notify'),
    iff = require('gulp-if'),
    LessAutoprefixer = require('less-plugin-autoprefix'),
    qunit = require('gulp-qunit'),
    rename = require('gulp-rename'),
    replace = require('gulp-replace'),
    del = require('del');
var autoprefixer = new LessAutoprefixer({browsers: ['last 2 versions']});

gulp.task('setup', ['less-setup', 'js-setup', 'css-setup', 'custom-js']);
gulp.task('less-setup',['less-one','less-two','less-three']);
gulp.task('less-one', function () {
    return gulp.src(['node_modules/bootstrap/less/**'])
        .pipe(gulp.dest('src/main/resources/static/less/bootstrap'));
});
gulp.task('less-two', function () {
    return gulp.src(['node_modules/font-awesome/less/**'])
        .pipe(gulp.dest('src/main/resources/static/less/font-awesome'));
});
gulp.task('less-three', function () {
    return gulp.src(['node_modules/pick-a-color/src/less/*.less'])
        .pipe(replace('bootstrap-src/', '../'))
        .pipe(gulp.dest('src/main/resources/static/less/pick-a-color'));
});
gulp.task('css-setup',function () {
    return gulp.src([
        'node_modules/datatables/media/css/jquery.dataTables.min.css',
        'node_modules/summernote/dist/summernote.css',
        'node_modules/select2/dist/css/select2.min.css'
    ])
        .pipe(gulp.dest('src/main/resources/static/dist/css'));
});

gulp.task('test', function() {
    return gulp.src('./src/test/resources/qunit/test-runner.html')
        .pipe(qunit());
});

gulp.task('js-setup', function () {
    return gulp.src([
        'node_modules/bootstrap/dist/js/bootstrap.min.js',
        'node_modules/jquery/dist/jquery.min.js',
        'node_modules/select2/dist/js/select2.min.js',
        'node_modules/tinycolor/tinycolor.js',
        'node_modules/pick-a-color/build/1.2.3/js/pick-a-color-1.2.3.min.js',
        'node_modules/summernote/dist/summernote.min.js',
        'node_modules/datatables/media/js/jquery.dataTables.min.js'
    ])
        .pipe(gulp.dest('src/main/resources/static/dist/js'));

});

gulp.task('custom-js', function () {
    return gulp.src('src/main/resources/static/js/*.js')
        .pipe(uglify())
        .pipe(rename({ suffix: '.min'}))
        .pipe(gulp.dest('src/main/resources/static/dist/js'));
});

gulp.task('style', ['setup'], function () {
    return gulp.src([
        'src/main/resources/static/less/base.less',
        'src/main/resources/static/less/frontend.less',
        'src/main/resources/static/css/**/*.css'
    ])
        .pipe(iff(/less/, less({
            paths: [path.join(__dirname, 'less', 'includes')],
            plugins: [autoprefixer]
        })))
        .pipe(rename({suffix: '.min'}))
        .pipe(css())
        .pipe(gulp.dest('src/main/resources/static/dist/css'));
});
gulp.task('clean', function () {
    return del(['src/main/resources/static/dist']);
});

gulp.task('default', function () {
    return gulp.start('clean');
});

gulp.task('go', ['clean'],function () {
    return gulp.start('style');
});
