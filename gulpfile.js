var gulp = require('gulp'),
    uglify = require('gulp-uglify'),
    concat = require('gulp-concat'),
    less = require('gulp-less'),
    css = require('gulp-clean-css'),
    autoprefixer = require('gulp-autoprefixer'),
    del = require('del');

gulp.task('styles', function() {
    return less('src/main/resources/static/less/frontend.less', { style: 'expanded' })
        .pipe(autoprefixer('last 2 version'))
        .pipe(gulp.dest('dist/styles'))
        .pipe(rename({ suffix: '.min' }))
        .pipe(cssnano())
        .pipe(gulp.dest('dist/styles'))
        .pipe(notify({ message: 'Styles task complete' }));
});
gulp.task('clean', function() {
    return del(['dist/styles', 'dist/scripts', 'dist/images']);
});
// gulp.task('default', ['clean'], function() {
//     gulp.start('styles', 'scripts', 'images');
// });
gulp.task('default', function() {
    gulp.start('clean');
})