# InSite Applications Take-Home Challenge - Backend

- Using Java or Kotlin and framework(s) of your choice (though we like [Spring Boot](http://projects.spring.io/spring-boot/)), create an API that accepts a freeform search query and returns a list of matching [Flickr](https://www.flickr.com/services/api/) titles and image URLs for various sizes. 
- Limit the response to ten titles. 
- This exercise isn't meant to take a long time, so don't spend more than an hour or so on it (unless you really want to). 
- When you are finished, please write a short paragraph (or some bullet points) describing what you perceive to be the pros and cons of your approach, and any alternatives you considered. We will not be judging your writing style or grammar.


For example:

```
curl http://localhost:8080/images?query=apple
```

Should return a response of the form:

```
[
   {
      "title":"Apple",
      "urls":[
         {
            "width":640,
            "height":480,
            "url":"https://farm5.staticflickr.com/4389/37190610481_f133ae5188_s.jpg"
         },
         {
            "width":320,
            "height":240,
            "url":"https://farm5.staticflickr.com/4389/37190610481_f133ae5188_q.jpg"
         }
      ]
   },
   {
      "title":"apples",
      "urls":[
         {
            "width":640,
            "height":480,
            "url":"https://farm5.staticflickr.com/4389/37160913742_39f4db7a40_s.jpg"
         },
         {
            "width":320,
            "height":240,
            "url":"https://farm5.staticflickr.com/4389/37160913742_39f4db7a40_q.jpg"
         }
      ]
   }
]
```


You may find the following Flickr documentation to be useful:

- [Search](https://www.flickr.com/services/api/flickr.photos.search.html)
- [Sizes](https://www.flickr.com/services/api/flickr.photos.getSizes.html)

You may use the following credentials:

- Flickr API Key: `80aafb8d5879b4ab3d58a6543021cd59`