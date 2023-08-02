<template>
    <div class="singleProduct">
        <ProductDetail :product="product" />
        <p>Item Id: {{product.id}}</p>
        <p>Find it in {{ product.category }}</p>
        <div>
            <router-link :to="{ name:'products' }">Back to Product Listing</router-link>
        </div>
    </div>
  
</template>

<script>
import ProductDetail from '@/components/ProductDetail.vue'

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
        this.product = this.$store.getters.getProductById(this.productId);
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