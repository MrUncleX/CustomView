# CustomView
个人研究自定义view
自定义ViweGroup的onDraw要强制调用，有两个方法
1，在构造函数里面，给其设置一个颜色，如#00000000。
2，在构造函数里面，调用setWillNotDraw(false)，去掉其WILL_NOT_DRAW flag。


造成这种现象的原因是ViewGroup，它本身并没有任何可画的东西，它是一个透明的控件，因些并不会触发onDraw，但是你现在给ViewGroup设置一个背景色，其实这个背景色不管你设置成什么颜色，系统会认为，这个ViewGroup上面有东西可画了，因此会调用onDraw方法。 

