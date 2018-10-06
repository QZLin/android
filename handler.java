//handler 实例
public void onclick（View view) {
        handler.post(thread);
    }
	
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // 获取Message里面的复杂数据
	    Bundle bundle = msg.getData();
	    String string = bundle.getString("key");
            // 主线程，可以直接对页面进行修改
            handler.post(thread);
        }
    };//不加这个分号则不能自动添加代码

    Runnable thread = new Runnable() {

        public void run() {
			//子线程
            Message msg = handler.obtainMessage();
            Bundle bundle = new Bundle();

            bundle.putInt("data", 000);

            msg.setData(bundle);
            handler.sendMessage(msg);

        }
    };//分号
