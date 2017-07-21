package com.androidedu.kodluyoruzakademi.activitylifecycle;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Sticker";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle);
        Log.e(TAG, "onCreate");
    }


    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.e(TAG, "onContentChanged");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState");
        // Aktiviteyi tekrar oluşturma ihtiyacı doğduğunda (Eski verilerin geri yüklenmesi)
        // sistem Bundle nesnesini hem onRestoreInstanceState() hem de
        // onCreate()  metotlarına iletir. Burada tekrar oluşturma ihtiyacı duyulmadığı için bu method çalışmamıştır.
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.e(TAG, "onPostCreate");
        //Etkinlik başlatma tamamlandığında (onStart () ve onRestoreInstanceState (Bundle) çağrıldıktan sonra) çağrılır.
        //Burada onRestoreInstanceState çağırımı gerçekleşmediği için etkinlik başlatma tamamlanamadı.
        //Böylelikle bu method çalışmamıştır.
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.e(TAG, "onPostResume");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e(TAG, "onAttachedToWindow");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        Log.e(TAG, "onCreateOptionsMenu");

        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        Log.e(TAG, "onPrepareOptionsMenu");
        return false;
        //Görüntülenecek ekranın standart seçenekler menüsünü hazırlar.
        //Aktivitenin standart seçenekler menüsünün içeriğini başlatılmadığı için bu method çalışmaz.

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
        //Etkinlik öldürülmediği -sonlandırılmadığı- için bu method çalışmaz.
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e(TAG, "onSaveInstanceState");
        //Bu metotta durum öldürülmeden önce bir etkinlikten örnek durumunu alması için çağrılır
        //ve böylece durumun onCreate (Bundle) veya onRestoreInstanceState (Bundle)'da geri yüklenmesi sağlanır.
        //Burada öldürülme durumu (onPause) metotu çalışmadığı için bu metot çalışmaz.
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
        //Activity arka plana atıldığı anda işleme girer. Activity arka plana atılmadığı için
        //bu metot çalışmaz.
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
        //Activity' e ait tüm kaynakların yok edildiği metot. Bu metotta activity yaşam döngüsünü
        //tamamlar. Burada herhangi bir yok ediş olmadığından dolayı metot çalışmaz.
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        Log.e(TAG, "onUserInteraction");
        //Herhangi bir tuşa, dokunma olayı etkinliğe gönderildiğinde etkinlik çağırılır.
        // Bu activity de böyle bir çağrışım olmadığı için bu metot çalışmaz.
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Log.e(TAG, "onUserLeaveHint");
        //Bir etkinlik, kullanıcı seçimi sonucunda arka plana geçmek üzereyken
        // etkinlik yaşam döngüsünün bir parçası olarak adlandırılır.
        //Arka plan işlemi gerçekleştirilmediği için bu metot çalışmaz.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult");
        //Başlatılan bir etkinlik çıkış yaptığında,başlatılan requestCode'u,
        // döndürdüğü resultCode'u ve ek verileri içeren bir etkinlik olduğunda çağrılır.
        //Burada bu çıkış yapılmadığı için metot çalışmaz.
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
        //Etkinliğiniz tekrar başlatılmadan önce durdurulduktan sonra çağrılır.
        //Etkinlik durdurulmadığı için bu metot çalışmaz.
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.e(TAG, "onAttachFragment");
        //Activity ile fragment arası iletişimde kullanılan metottur.
        //Bu activity de fragment yer almadığı için metot çalışmaz.
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG, "onConfigurationChanged");
        //Etkinlik çalışırken cihaz yapılandırması değiştiğinde sistem tarafından çağrılır.
        //Bu activity de herahangi bir yapılandırma olmadığı için metot çalışmaz.
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e(TAG, "onBackPressed");
        //Etkinlik kullanıcının geri tuşa basmasını tespit ettiğinde çağrılır
        //Herhangi bir etkileşim olmadığı için bu metot çalışmaz.
    }

}
