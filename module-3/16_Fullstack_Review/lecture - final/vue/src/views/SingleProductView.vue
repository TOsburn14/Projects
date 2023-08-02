<template>
<div>
    <div v-if="!product">
        <img src="../assets/loading_icon.gif" alt="">
    </div>
    <div class="singleProduct" v-if="product">
        <ProductDetail :product="product" />
        <p>Item Id: {{product.id}}</p>
        <p>Find it in {{ product.category }}</p>
        <div>
            <router-link :to="{ name:'products' }">Back to Product Listing</router-link>
        </div>
    </div>
  </div>
</template>

<script>
import ProductDetail from '@/components/ProductDetail.vue'
import productService from '@/services/ProductService.js'

export default {
    components: {
        ProductDetail
    },
    data() {
        return {
            productId: 0,
            product: null
        }
    },
    created() {
        this.productId = this.$route.params.productId;
        productService.getProductById(this.productId).then( response => {
            this.product = response.data;
        }).catch( err => console.error(err) );
    }
}
</script>

<style>
div.singleProduct {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items:center;
}
div.singleProduct a {
    text-decoration: none;
    font-size: 1.2rem;
    color: darkblue;
}
div.singleProduct a:hover {
    color: purple;
    text-decoration: underline;
}
</style>