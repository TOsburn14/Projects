import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '@/views/Products'
import ProductDetail from '@/views/ProductDetail'
import AddReview from '@/views/AddReview'
import NotFound from '@/views/NotFound'
import Store from '@/store/index.js'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Products,
    name: 'products'
  },
  {
    path: '/products/:id',
    component: ProductDetail,
    name: 'product-detail'
  },
  {
    path: '/products/:id/addreview',
    name: 'add-review',
    component: AddReview
  },
  {
    path: '/products',
    redirect: { name: 'products' }
  },
  {
    path: '*',
    name: 'notFound',
    component: NotFound
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

/*
  to - an object that represents where the user is going
  from - an object that represents where the user came from
  next - a function that will send the user to their next location
*/
router.beforeEach( (to, from, next) => {

  // determine if the user is going to a route that has an id (product detail and Add Review)
  if (to.name === 'product-detail' || to.name === 'add-review') {
    // Get the id from the route (url)
    const id = to.params.id;
    // Get the product with that id from the VueX store
    const product = Store.state.products.find ( product => product.id == id);
    // if that product does not exist then redirect to the 404
    if (!product) {
      next( {name: 'notFound'} );
    }
  }
  // If we are still here then send the user to their original destination
  next();
})

export default router
