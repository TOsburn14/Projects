<template>
  <div class="reviews">
      <ReviewDisplay v-for="currentReview in filteredReviews" 
        v-bind:key="currentReview.id"
        v-bind:review="currentReview"
         />
        <div v-if="reviewsFound">
            <p>No {{ $store.state.filter }} Star Reviews Found</p>
        </div>
  </div>
</template>

<script>
import ReviewDisplay from './ReviewDisplay.vue'

export default {
    name: 'review-list',
    components: {
        ReviewDisplay
    },
    computed: {
        filteredReviews() {
            const reviews = this.$store.state.reviews;
            const currentFilter = this.$store.state.filter;
            return reviews.filter( review => {
                return currentFilter === 0 ? true : currentFilter === review.rating;
            });
        },
        reviewsFound() {
            return this.filteredReviews.length === 0;
        }
    }
}
</script>

<style>

</style>