<template>
  <header>
    <img src="../assets/temart-logo.png" alt="">
    <div>
        Menu
    </div>
  </header>
</template>


<script>
export default {
  name: "page-header",
};
</script>


<style>
header{
    display: flex;
    align-items: center;
    justify-content: space-between;
    height: 100px;
}
img {
    width: 150px;
}

</style>