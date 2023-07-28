<template>
    <div class="product" v-bind:class="{ bestseller : product.is_top_seller }">
        <h2>{{product.name}}</h2>
        <img v-bind:src="require('../assets/product-images/' + product.image_name)" alt="">
        <div class="rating">
        <img src="../assets/star.png" class="ratingStar"
            v-for="n in numberOfStars" v-bind:key="n">
        <img src="../assets/star_empty.png" class="ratingStar"
            v-for="n in numberOfEmptyStars" v-bind:key="'empty-' + n">
        </div>
        <p>{{ '$' + Number(product.price).toFixed(2) }}</p>

        <div class="notices">
        <span v-if="product.is_top_seller" class="topseller">Top Seller</span>
        <span v-if="product.quantity === 0" class="limitedstock">Sold Out</span>
        <span v-if="product.quantity > 0 && product.quantity <= 3" class="limitedstock">Only {{ product.quantity }} Left</span>
        </div>
        <div class="addToCart">
        <a href="#" v-on:click.prevent="addProductToCart(product.id)">Add to Cart</a>
        </div>
    </div>
</template>

<script>
export default {
    name: 'product-detail',
    props: ['product'],
    computed: {
      numberOfStars() {
        return parseInt(this.product.rating);
      },
      numberOfEmptyStars() {
        return 5 - this.numberOfStars;
      },
    },
    methods: {

      addProductToCart(productId) {
        const product = this.products.find( p => p.id == productId);
        this.shoppingCart.push(product);
      }
    }
}
</script>

<style>

</style>