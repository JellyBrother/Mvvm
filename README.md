# Mvvm
安卓开发应用。集成了mvvm、livedata、databinding、阿里arouter
提供了多语言国际化参考
提供了暗黑模式，阿拉伯语言参考
提供了架构文件夹分类别参考

### base库
* viewmodel可以继承BaseActivity，业务逻辑继承BaseViewModel进行管理
* 简单的activity直接使用BaseViewModel即可。
* databinding需要继承BaseDataBindingActivity
* activity已经处理了状态栏，状态栏颜色，需要设置activity的主题。
* 大屏幕设备适配，需要使用ColumnUtil，得遵循一定的设计规范。

### bridge库
* 可以管控各个子模块的初始化
* 可以管控各个模块的主fragment
* 可以管控各个模块的跳转，统一基座进行跳转
* 新增管控等等，可以在IModel增加方法，或者继承IModel处理。

### 小项目和新项目可以使用base库即可

### 超级app，特别是集成其他app改造成aar后，几个集成为一个的时候需要依赖base库和bridge库。
* 各个模块需要依赖base，Application的引用、各个模块不能在Application提前初始化必要的功能
* 在各个需要初始化的AndroidManifest.xml中添加meta-data，基座真正的Application去读取参数进行初始化，或者进行必要的页面传递，模块页面jump等等。
* 第二种说的是超级app集成的场景，目前这个项目对小型app的模块化够用了。
* base的constan初始化可以参考
