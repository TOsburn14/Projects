<template>
  <div id="products">
      <h1>Products</h1>
      <div class="productList">
        <div class="product" v-for="product in products" v-bind:key="product.id"
          v-bind:class="{ bestseller : product.is_top_seller }">
          <h2>{{product.name}}</h2>
          <img v-bind:src="require('../assets/product-images/' + product.image_name)" alt="">
          <div class="rating">
            <img src="../assets/star.png" class="ratingStar"
              v-for="n in numberOfStars(product.rating)" v-bind:key="n">
            <img src="../assets/star_empty.png" class="ratingStar"
              v-for="n in numberOfEmptyStars(product.rating)" v-bind:key="'empty-' + n">
          </div>
          <p>{{ '$' + Number(product.price).toFixed(2) }}</p>
          <div class="notices">
            <span v-if="product.is_top_seller" class="topseller">Top Seller</span>
            <span v-if="product.quantity === 0" class="limitedstock">Sold Out</span>
            <span v-if="product.quantity > 0 && product.quantity <= 3" class="limitedstock">Only {{ product.quantity }} Left</span>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
export default {
    name: 'product-list',
    data() {
      return {
        products: []
      }
    },
    methods: {
      numberOfStars(rating) {
        return parseInt(rating);
      },
      numberOfEmptyStars(rating) {
        return 5 - this.numberOfStars(rating);
      }
    },
    created() {
      fetch('products.json').then( response => {
        return response.json();
      }).then( data => this.products = data );
    }
}
</script>

<style>
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