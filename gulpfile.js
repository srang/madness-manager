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

gulp.task('style', function() {
    return gulp.src('src/main/resources/static/styles/**/*.{less,css}')
        .pipe(less({
            paths: [path.join(__dirname, 'less', 'includes')],
            plugins: [autoprefixer]
        }))
        .pipe(gulp.dest('src/main/resources/static/dist'))
        .pipe(rename({ suffix: '.min' }))
        .pipe(css())
        .pipe(gulp.dest('src/main/resources/static/dist'))
        .pipe(notify({ message: 'Styles task complete' }));
});
gulp.task('clean', function() {
    return del(['src/main/resources/static/dist']);
});
// gulp.task('default', ['clean'], function() {
//     gulp.start('styles', 'scripts', 'images');
// });
gulp.task('default', function() {
    gulp.start('clean');
})