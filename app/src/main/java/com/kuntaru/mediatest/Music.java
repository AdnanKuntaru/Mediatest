package com.kuntaru.mediatest;

public class Music {
        private String Sura;
        private String Aya;
        private int mAudioResourceId;

        public Music(String sura, String aya, int  audioResourceId ) {
            Sura = sura;
            Aya = aya;
            mAudioResourceId = audioResourceId;
        }

        public String getSura() {
            return Sura;
        }

        public String getAya() {
            return Aya;
        }

        public int getAudioResourceId(){
            return mAudioResourceId;
        }

}
