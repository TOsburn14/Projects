<template>
<div>
<div class="loading" v-if="isLoading">
    <img src="../assets/loading_icon.gif" />
</div>
<div class="error" v-if="errorMessage">
    Error: {{errorMessage}}
</div>
  <div id="app" class="main" v-if="!isLoading">
      <h1>{{product.name}}</h1>
      <p class="description">{{ product.description }}</p>
      <div class="actions">
          <router-link v-bind:to="{ name:'products' }">Back to Products</router-link>
          &nbsp;|&nbsp;
          <router-link v-bind:to="{ 
              name: 'add-review', 
              params: {
                  id: product.id
              }
          }">
              Add Review
          </router-link>
      </div>
      <div class="well-display">
          <AverageSummary v-bind:reviews="product.reviews"/>
          <StarSummary rating="1" :reviews="product.reviews"/>
          <StarSummary rating="2" :reviews="product.reviews"/>
          <StarSummary rating="3" :reviews="product.reviews"/>
          <StarSummary rating="4" :reviews="product.reviews"/>
          <StarSummary rating="5" :reviews="product.reviews" />
      </div>
      <ReviewList :reviews="product.reviews"/>
  </div>
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary'
import StarSummary from '@/components/StarSummary'
import ReviewList from '@/components/ReviewList'
import ProductService from '../Services/ProductService.js'

export default {
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    data() {
        return {
        product: {},
        isLoading: true,
        errorMessage: ''
        }
    },
    
    created() {
        const activeProductId = this.$route.params.id;
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductId);

        ProductService.getProductById(activeProductId)
            .then( response => {
                this.product = response.data;
                this.isLoading = false;
            })
            .catch( errorObj => {
                console.error(errorObj);

                if (errorObj.response) {
                    if (errorObj.response.status === 404) {
                        this.$router.push({name: 'not-found'});
                    } else {
                        this.errorMessage = errorObj.response.status + ' : ' + errorObj.response.statusText;
                    }
                } else if ( errorObj.request ) {
                    this.errorMessage = 'The server could not be reached.';
                } else {
                    this.errorMessage = 'Unexpected Error.';
                }
                this.isLoading = false;
            })
    }
}
</script>

<style>
div.loading {
    height: 75vw;
    display:flex;
    justify-content: center;
    align-items: center;
}

div.error {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top:50px;
    background-color: red;
    color: white;
    height: 50px;
    font-size: 1.5rem;
}
</style>