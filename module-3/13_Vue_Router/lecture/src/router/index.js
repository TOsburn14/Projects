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
  redirect: {name: 'products'}
},
{
  path: '*',
  name: 'notFound',
  component: NotFound
},

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach( (to, from, next) => {
    if (to.name === 'product-detail' || to.name === 'add-review') {
      const id = to.params.id;
      const product = Store.state.products.find ( product => product.id == id );
      if (!product) {
        next( {name: 'notFound'} );
      }
    }
    next();
})

export default router
