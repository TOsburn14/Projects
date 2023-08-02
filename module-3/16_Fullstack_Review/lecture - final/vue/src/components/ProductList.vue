<template>
  <div id="products">
      <h1>Products</h1>
      <div class="productList">
        <ProductDetail v-for="currentProduct in filteredProducts" 
          v-bind:key="currentProduct.id"
          v-bind:product="currentProduct"  />
      </div>
  </div>
</template>

<script>
import ProductDetail from '@/components/ProductDetail.vue'

export default {
    name: 'product-list',
    components: {
      ProductDetail
    },
    data() {
      return {
        
        
      }
    },
    computed: {
      filteredProducts() {
        return this.$store.getters.products.filter( product => {
          const currentFilter = this.$store.state.categoryFilter;
          if (currentFilter === 'All') {
            return true;
          }
          if (currentFilter === product.category) {
            return true;
          }
          return false;
        });
      }
    },
}
</script>

<style>
div.productList div.addToCart {
  margin-bottom: 10px;
}

div.productList div.addToCart a {
  text-decoration: none;
  color: black;
  font-size: .9rem;
  font-weight: 700;
}

div.productList div.addToCart a:hover {
  text-decoration: underline;
  color: blue;
}

div.productList {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
div.product {
   border: 1px black solid;
   width: 30%;
   margin: 20px;
   border-radius: 5px;
   display: flex;
   flex-direction: column;
   justify-content: space-between;
}




div.product.bestseller {
   background-color: lightyellow;
}
div.product img {
   width: 75%;
   max-height: 200px;
   align-self: center;
}
div.product h2 {
   font-size: 1.1rem;
   color: black;
}




div.rating {
   display: flex;
   justify-content: center;
   margin-top: 5px;




}
div.rating img.ratingStar {
   width: 20px;
}




div.product div.notices {
   display: flex;
   justify-content: space-between;
   align-content: flex-end;
   margin-right: 10px;
   margin-left: 10px;
   margin-bottom: 5px;
   font-weight: 800;
}
div.product div.notices span.topseller {
   color: blue;
}
div.product div.notices span.limitedstock {
   color: red;
}

</style>