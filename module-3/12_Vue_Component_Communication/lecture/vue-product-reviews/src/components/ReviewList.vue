<template>
  <div class="reviews">
      <ReviewDisplayVue v-for="currentReview in filteredReviews"
      v-bind:key="currentReview.id"
      v-bind:review="currentReview"
      />
         <div v-if="filteredReviews.length === 0">
            <p>No {{ $store.state.filter }} Star Reviews Found</p>
        </div>


  </div>
</template>

<script>
import ReviewDisplayVue from './ReviewDisplay.vue'
export default {
    name: 'review-list',
    components: {
        ReviewDisplayVue
    },
    computed: {
           filteredReviews() {
               const reviews = this.$store.state.reviews;
               const currentFilter = this.$store.state.filter;
            return reviews.filter( review => {
                return currentFilter === 0 ? true : currentFilter === review.rating;
            });
        },
        noReviewsFound() {
            return this.filteredReviews.length === 0;
 

        }
    }
}
</script>

<style>

</style>