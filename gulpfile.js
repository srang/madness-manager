var gulp = require('gulp'),
    uglify = require('gulp-uglify'),
    concat = require('gulp-concat'),
    less = require('gulp-less'),
    path = require('path'),
    css = require('gulp-clean-css'),
    notify = require('gulp-notify'),
    LessAutoprefixer = require('less-plugin-autoprefix'),
    rename = require('gulp-rename'),
    del = require('del');
var autoprefixer = new LessAutoprefixer({ browsers: ['last 2 versions'] });

gulp.task('setup', function() {
    gulp.src([
        'node_modules/bootstrap/dist/js/bootstrap.min.js',
        'node_modules/jquery/dist/jquery.min.js',
        'node_modules/select2/dist/js/select2.min.js',
        'node_modules/tinycolor/tinycolor.js',
        'node_modules/pick-a-color/build/1.2.3/js/pick-a-color-1.2.3.min.js',
        'node_modules/summernote/dist/summernote.min.js',
        'node_modules/datatables/media/js/jquery.dataTables.min.js'
    ])
        .pipe(gulp.dest('src/main/resources/static/dist/js'));

    gulp.src([
    ])
        .pipe(gulp.dest('src/main/resources/static/dist/css'));

    gulp.src([
        'node_modules/bootstrap/less/**/*.less',
        'node_modules/font-awesome/less/*.less'
    ])
        .pipe(gulp.dest('src/main/resources/less'))
});

gulp.task('style', ['setup'], function() {
    return gulp.src('src/main/resources/static/less/**/*.{less,css}')
        .pipe(less({
            paths: [path.join(__dirname, 'less', 'includes')],
            plugins: [autoprefixer]
        }))
        .pipe(gulp.dest('src/main/resources/static/dist/css'))
        .pipe(rename({ suffix: '.min' }))
        .pipe(css())
        .pipe(gulp.dest('src/main/resources/static/dist/css'));
});
gulp.task('clean', function() {
    return del(['src/main/resources/static/dist']);
});

gulp.task('default', function() {
    gulp.start('clean');
})