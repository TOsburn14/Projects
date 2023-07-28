<template>
    <div class="singleProduct">
        <ProductDetailVue :product="product"/>
    </div>
</template>

<script>
import ProductDetailVue from './ProductDetail.vue';
export default {
    components: {
        ProductDetailVue
    },
        data(){
        return {
            productId: 0,
            product: null
        }
    },
    created() {
        this.productId = this.$route.params.productId;
        this.product = this.$store.getters.getProductById(this.productId)
    }
}
</script>

<style>

</style>