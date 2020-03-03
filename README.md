Bug Reproduction
================

Bug reporting

### 1- [geftimov/android-viewpager-transformers](https://github.com/geftimov/android-viewpager-transformers)

Click "Open Geftimov Transformer Bug".

If you click right side of the page, next page will come and if you click left side of the page, previous one will come.

* [CubeOutTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/CubeOutTransformer) is failing when offscreen page limit is 3 and when you are at page 3 or after.
* [CubeInTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/CubeInTransformer) is also failing when offscreen page limit is 3 and when you are at page 2 or after.(Change transformer in activity to try)
* I haven't tested others but these ones caused a lot of troubles for me. Please care.