# Mvvm
安卓开发应用。集成了mvvm、livedata、databinding、阿里arouter
### 目前模块分离还不够彻底
* 各个模块需要依赖base，Application的引用、各个模块不能在Application提前初始化必要的功能
* 在各个需要初始化的AndroidManifest.xml中添加meta-data，基座真正的Application去读取参数进行初始化，或者进行必要的页面传递，模块页面jump等等。
* 第二种说的是超级app集成的场景，目前这个项目对小型app的模块化够用了。
* base的constan初始化可以参考
