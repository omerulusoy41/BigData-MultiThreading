## BÜYÜK VERİDE MULTITHREADING İLE BENZER KAYITLARIN TESPİT EDİLMESİ
Müşteri şikayetleri kayıtlarının tutulduğu bir veri seti içerisindeki benzer kayıtlar tespit
edilecek ve tespit edilen kayıtlar masaüstü uygulamasında gösterilecektir. Multithreading
kullanarak benzerlik arama süresini düşürmek amaçlanmaktadır

## Kaynak Dosyasi
https://www.kaggle.com/datasets/selener/consumer-complaint-database

### Amac 
- Veri seti içerisindeki arama işlem süresini multithreading kullanılarak azaltmak.
- Belirtilen sütun/sütunlar için her bir satırdaki kayıtların birbiriyle kelime bazlı
karşılaştırılması ve aralarındaki benzerliğin tespit edilmesi.
- Uygulama içerisinde istenen özelliklere göre kayıtları filtrelemek ve kullanıcıya
göstermek.

### Isterler
- Veri seti aşağıdaki kurallara uygun olacak şekilde yeniden düzenlenmelidir:
- Elde edilen tabloda 6 farklı sütun bulunmalıdır: Product (Ürün), Issue (Konu),
Company (Şirket), State, Complaint ID, Zip Code.
- Null değer içeren kayıtlar bulunmamalıdır.
- Kayıtlardaki noktalama işaretleri kaldırılmalıdır.
- Kayıtlardaki stop word’ler kaldırılmalıdır (nltk kütüphanesi kullanılabilir).


### Mutlithreading nedir
Multithreading (çok iş parçacıklı çalışma), bir merkezi işlem biriminin (CPU) (veya çok
çekirdekli bir işlemcideki tek bir çekirdeğin) aynı anda işletim sistemi tarafından desteklenen
birden çok yürütme iş parçacığı sağlama yeteneğidir.
Bu tür programlamada birden çok iş parçacığı aynı anda çalışır. Çok iş parçacıklı model,
sorgulamalı olay döngüsü kullanmaz. CPU zamanı boşa harcanmaz. Boşta kalma süresi
minimumdur. Daha verimli programlarla sonuçlanır. Herhangi bir nedenle bir iş parçacığı
duraklatıldığında, diğer iş parçacıkları normal şekilde çalışır

## Ekran Goruntuleri(kaynak 100 satir alinarak test edilmistir. ) 
- ![Profile](https://github.com/omerulusoy41/BigData-MultiThreading/blob/master/Ekran%20G%C3%B6r%C3%BCnt%C3%BCs%C3%BC%20(25).png)  
- ![Profile](https://github.com/omerulusoy41/BigData-MultiThreading/blob/master/Ekran%20G%C3%B6r%C3%BCnt%C3%BCs%C3%BC%20(26).png)  
- ![Profile](https://github.com/omerulusoy41/BigData-MultiThreading/blob/master/Ekran%20G%C3%B6r%C3%BCnt%C3%BCs%C3%BC%20(27).png)
