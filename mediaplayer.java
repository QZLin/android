//able to play mp3 in assets
public void playFile(String name) {
        try {
            AssetFileDescriptor fileDescriptor = getAssets().openFd(name);

            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(), fileDescriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
