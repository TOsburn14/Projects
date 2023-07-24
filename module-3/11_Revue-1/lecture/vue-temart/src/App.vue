<template>
  <div id="app">
    <PageHeader />
    <ProductList />
    <PageFooter />
  </div>
</template>

<script>
import PageHeader from "@/components/PageHeader";
import ProductList from "@/components/ProductList";
import PageFooter from "@/components/PageFooter";

export default {
  name: "App",
  components: {
    PageHeader,
    ProductList,
    PageFooter,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100vh;
  display: grid;
  padding-top: 20px;
  grid-template-columns: 2vw 1fr 2vw;
  grid-template-rows: 125px 1fr 100px;
  grid-template-areas:
    ". header ."
    ". main ."
    ". footer .";
}

header {
  grid-area: header;
}
div#products {
  grid-area: main;
}
footer {
  grid-area: footer;
}
</style>
