handler = @SuppressLint("HandlerLeak")
        object : Handler() {

            override fun handleMessage(msg: Message) {
                if (msg.what == 1) {
                    setContentView(R.layout.activity_main)

                    if (getData("FirstTime") == "") {
                        showTipDialog()
                        saveData("FirstTime", "False")
                    }

                    showAboutDialog()

                    hide()
                    menuEvent()
                }
            }
        }
        handler.sendEmptyMessageDelayed(1, 2000)
