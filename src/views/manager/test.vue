<template>  
    <div class="image-text-container">  
  <img src="your-image.jpg" alt="描述性文字" class="inline-image">  
  <p class="inline-text">这是文字，它位于图片的左边</p>  
</div>
  </template>  
    
  <script>  
  
  </script>  
    
  <style scoped>  
.image-text-container {  
  display: flex;  
  align-items: center; 
}  
  
.inline-image {  
  width: 100px; 
  height: auto;
  margin-right: 10px; 
}  
  
.inline-text {  
  vertical-align: middle; 
}
  </style>