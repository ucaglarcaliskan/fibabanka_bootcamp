# Fibabanka Bootcamp

Bu proje Fibabanka Spring Boot bootcamp'i kapsamında hazırlanmıştır. 

Proje kapsamında Inventory, Shopping ve Commerce olmak üzere 3 microservice geliştirilmiştir.<br>
Invertory mikroservisi ürünler ve kategoriler ile ilgili veritabanı işlemelerini yapmakta ve REST servisi sayesinde gelen HTTP isteklerine cevap vermektedir.<br>
Shopping mikroservisi sepet ile ilgili veritabanı işlemelerini yapmakta ve REST servisi sayesinde gelen HTTP isteklerine cevap vermektedir.<br>
Commerce mikroservisi ise diğer iki mikroservise istek atarak onları yönetmekte ve Client için arayüz sunmaktadır.<br>

<h3>Gönderilebilecek istekler</h3>
<ul>
<li> GET http://localhost:8080/commerce/inventory/categories -> Kategorileri getirir
<li> GET http://localhost:8080/commerce/inventory/products/{categoryId} -> İlgili kategoriye ait ürünleri getirir.
<li> GET http://localhost:8080/commerce/inventory/product/{productId} -> Id'si verilen ürünü getirir.
<li> GET http://localhost:8080/commerce/shopping/cart/create -> Yeni bir sepet oluşturarak id'sini döndürür.
<li> POST http://localhost:8080/commerce/shopping/cart/add -> Body olarak verilen ürünü sepete ekler.
<li> DELETE http://localhost:8080/commerce/shopping/cart/{cartId}/remove/{productId} -> Sepetten ürünü siler.
<li> GET http://localhost:8080/commerce/shopping/checkout/{cartId} -> Sepeti bitirir.
<li> GET http://localhost:8080/commerce/shopping/cart/find/{cartId} -> Sepet detaylarını getirir.
</ul>

<h3>Test Senaryosu ve Ekran Görüntüleri</h3>
POST DELETE gibi HTTP isteklerini gösterebilmek RestTemplate kullanılarak bir http://localhost:8080/<b>test</b>/... ile başlayan istekleri alan bir controller oluşturulmuş ve client simüle edilmiştir. Eğitmenin önerisi üzerine test senaryosu bu client'a atılan GET istekleriyle gösterilmiş, client ise gelen GET isteklerine karşılık projede istenen istekleri göndermektedir. POSTMAN ya da cURL gibi bir araçla da bu istekler gönderilebilir (Test edilmiştir).

1. http://localhost:8080/test/commerce/inventory/categories adresine GET isteği atılarak veritabanında kayıtlı olan kategoriler getirilmiştir.
http://localhost:8080/test/commerce/inventory/categories adresine istek atılarak da JSON formatında çıktı alınabilir.
![1](https://user-images.githubusercontent.com/38859052/200677832-45ece3a3-54df-4007-8ddd-9a00fafb6925.PNG)

2. http://localhost:8080/test/commerce/inventory/productsByCategory adresine istek atıldığında kategori id'si 1 olan ürünlerin getirilmesi sağlanmıştır.
http://localhost:8080/commerce/inventory/products/{categoryId} adresine istek atılarak da ürünler JSON formatında alınabilir.![2](https://user-images.githubusercontent.com/38859052/200678556-f16a66a6-3d37-469b-a288-7e3df74d6290.PNG)

3. http://localhost:8080/test/commerce/inventory/product adresine istek atıldığında ürün id'si 2 olan ürün getirilmiştir. http://localhost:8080/commerce/inventory/product/{productId} adresine istek atılarak bu ürünün bilgileri JSON formatında alınabilir.
![3](https://user-images.githubusercontent.com/38859052/200678818-fd56211f-3f42-45ae-ae5f-c55c27291449.PNG)

4. http://localhost:8080/test/commerce/shopping/cart/create adresine istek atıldığında yeni sepet oluşturulması sağlanmıştır.
http://localhost:8080/commerce/shopping/cart/create adresine istek atılarak da aynı işlem yapılabilir. 
![4](https://user-images.githubusercontent.com/38859052/200679073-9119db53-4cce-4846-bca7-fe1afdf497a3.PNG)

5. http://localhost:8080/test/commerce/shopping/cart/add adresine istek atıldığında default olarak productId'si 2 olan ürünün cartId'si 3 olan sepete eklenmesi sağlanmıştır. http://localhost:8080/commerce/shopping/cart/add adresine POST isteği atılarak istenen ürün sepete eklenebilir.<br>
![5](https://user-images.githubusercontent.com/38859052/200680369-940813cd-666f-4192-8e9d-f1eb20d72c73.PNG)

6. http://localhost:8080/test/commerce/shopping/cart/removeProduct adresine GET isteği atıldığında cartId'si 3 olan sepetten productID'si 2 olan ürünün silinmesi sağlanmıştır. http://localhost:8080/commerce/shopping/cart/{cartId}/remove/{productId} adresine DELETE isteği atarak istenen ürün sepetten silinebilir.<br>
![8](https://user-images.githubusercontent.com/38859052/200682199-7f6d7c82-e069-4cb6-ae7b-a6163fbb8905.PNG)<br>
Silindikten sonra sepet detayı:<br>
![9](https://user-images.githubusercontent.com/38859052/200682295-56472e13-601b-4dae-8cc9-7a56bdefc337.PNG)

7. http://localhost:8080/test/commerce/shopping/checkout adresine GET isteği atıldığında cartId'si 3 olan sepetin bitirilmesi sağlanmıştır. 
http://localhost:8080/commerce/shopping/checkout/{cartId} adresine cartId verilerek istenen sepetin bitirilmesi sağlanabilir.
![7](https://user-images.githubusercontent.com/38859052/200681824-f858894f-5597-4788-99c6-a59378a7d0f5.PNG)

8. http://localhost:8080/test/commerce/shopping/cart/find adresine GET isteği atıldığında cartId'si 3 olan sepetin detayları gösterilmiştir.
http://localhost:8080/commerce/shopping/cart/find/{cartId} adresine cartId ile istek atılarak sepetin detaylarına JSON formatında ulaşılabilir.<br>
![6](https://user-images.githubusercontent.com/38859052/200682133-8f1e4341-db3c-4eff-849a-2f26456938fb.PNG)
