import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import legalterms from '@/views/modules/legalterms/list'
    import news from '@/views/modules/news/list'
    import discussbankoutlet from '@/views/modules/discussbankoutlet/list'
    import notificationinformation from '@/views/modules/notificationinformation/list'
    import wealthmanagementproducts from '@/views/modules/wealthmanagementproducts/list'
    import discusswealthmanagementproducts from '@/views/modules/discusswealthmanagementproducts/list'
    import productclassification from '@/views/modules/productclassification/list'
    import bankoutlet from '@/views/modules/bankoutlet/list'
    import loanmethods from '@/views/modules/loanmethods/list'
    import loanproducts from '@/views/modules/loanproducts/list'
    import loanapplication from '@/views/modules/loanapplication/list'
    import examnotice from '@/views/modules/examnotice/list'
    import leaveapplication from '@/views/modules/leaveapplication/list'
    import workschedule from '@/views/modules/workschedule/list'
    import config from '@/views/modules/config/list'
    import bankemployee from '@/views/modules/bankemployee/list'
    import customer from '@/views/modules/customer/list'
    import preciousmetals from '@/views/modules/preciousmetals/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: 'The home page of the system',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: 'The home page of the system',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: 'modifyPassword',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: 'Personal Information',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/legalterms',
        name: 'legal provisions',
        component: legalterms
      }
      ,{
	path: '/news',
        name: 'Notice Announcement',
        component: news
      }
      ,{
	path: '/discussbankoutlet',
        name: 'Bank network',
        component: discussbankoutlet
      }
      ,{
	path: '/notificationinformation',
        name: 'notification information',
        component: notificationinformation
      }
      ,{
	path: '/wealthmanagementproducts',
        name: 'Financial product ',
        component: wealthmanagementproducts
      }
      ,{
	path: '/discusswealthmanagementproducts',
        name: 'Financial product ',
        component: discusswealthmanagementproducts
      }
      ,{
	path: '/productclassification',
        name: 'product class',
        component: productclassification
      }
      ,{
	path: '/bankoutlet',
        name: 'Bank network',
        component: bankoutlet
      }
      ,{
	path: '/loanmethods',
        name: 'Loan method',
        component: loanmethods
      }
      ,{
	path: '/loanproducts',
        name: 'Loan product ',
        component: loanproducts
      }
      ,{
	path: '/loanapplication',
        name: 'loan application',
        component: loanapplication
      }
      ,{
	path: '/examnotice',
        name: 'Examination Notice',
        component: examnotice
      }
      ,{
	path: '/leaveapplication',
        name: 'Leave Application',
        component: leaveapplication
      }
      ,{
	path: '/workschedule',
        name: 'order of the day',
        component: workschedule
      }
      ,{
	path: '/config',
        name: 'Rotation chart management',
        component: config
      }
      ,{
	path: '/bankemployee',
        name: 'Bank employees',
        component: bankemployee
      }
      ,{
	path: '/customer',
        name: 'client',
        component: customer
      }
      ,{
	path: '/preciousmetals',
        name: 'precious metal',
        component: preciousmetals
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: 'The home page of the system',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//modify原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
