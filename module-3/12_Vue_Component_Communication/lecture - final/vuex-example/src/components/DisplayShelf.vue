<template>
  <div>
      <h1 class="sign">TVs for Sale!</h1>
      <h2 v-if="stockRemains" class="sign">
        <!-- Here the VueX Store is used to display the inventory number 
          in the template, VueX is accessed using the built in $store 
          variable.

          State can be be accessed directly when getting a value, but never
          when setting it.
        -->
        Hurry only {{ $store.state.inventory.tvs }} Remain!!
      </h2>
      <h2 v-else class="sign">
          SOLD OUT!
      </h2>
      <div class="shelf">
          <!-- the VueX store is used to determine how much stock to display 

              State can also be accessed used a Getter.  Getters are not always
              required for just getting a simple value from state.  However, they
              do provide a form of encapsulation, which means how the current TV Inventory
              is calculated can be changed without the need to change the component
              code, similar to how Getters work in Java.
          -->
          <img 
              v-for="n in $store.getters.currentTvInventory"
              v-bind:key="n"
              src="../assets/tv.jpg" />
      </div>
  </div>
</template>

<script>
export default {
  computed: {
    stockRemains() {
      /* Uses the VueX state to determine if stock remains
          In the script the VueX $store variable can be accessed
          using the this keyword.
      */
      return this.$store.getters.currentTvInventory > 0;
    }
  }
}
</script>

<style>

div.shelf {
  display: flex;
  width: 800px;
  justify-content: flex-start;
  margin: 0 auto;
  border-bottom: 10px black solid;
}

img {
  width: 150px;
}

h1.sign {
  background-color: blue;
  width: 500px;
  margin: 0 auto;
  margin-bottom: 0px;
  border-radius: 10px;
  line-height: 50px;
  color: whitesmoke;
}

h2.sign {
  background-color: red;
  width: 400px;
  margin: 0 auto;
  margin-top: 0px;
  margin-bottom: 20px;
  border-radius: 0px 0px 10px 10px;
  font-size: 1.5rem;
  color: yellow;
}

</style>