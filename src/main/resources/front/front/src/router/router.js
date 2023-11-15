import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import bankemployeeList from '../pages/bankemployee/list'
import bankemployeeDetail from '../pages/bankemployee/detail'
import bankemployeeAdd from '../pages/bankemployee/add'
import customerList from '../pages/customer/list'
import customerDetail from '../pages/customer/detail'
import customerAdd from '../pages/customer/add'
import productclassificationList from '../pages/productclassification/list'
import productclassificationDetail from '../pages/productclassification/detail'
import productclassificationAdd from '../pages/productclassification/add'
import loanmethodsList from '../pages/loanmethods/list'
import loanmethodsDetail from '../pages/loanmethods/detail'
import loanmethodsAdd from '../pages/loanmethods/add'
import loanproductsList from '../pages/loanproducts/list'
import loanproductsDetail from '../pages/loanproducts/detail'
import loanproductsAdd from '../pages/loanproducts/add'
import loanapplicationList from '../pages/loanapplication/list'
import loanapplicationDetail from '../pages/loanapplication/detail'
import loanapplicationAdd from '../pages/loanapplication/add'
import wealthmanagementproductsList from '../pages/wealthmanagementproducts/list'
import wealthmanagementproductsDetail from '../pages/wealthmanagementproducts/detail'
import wealthmanagementproductsAdd from '../pages/wealthmanagementproducts/add'
import bankoutletList from '../pages/bankoutlet/list'
import bankoutletDetail from '../pages/bankoutlet/detail'
import bankoutletAdd from '../pages/bankoutlet/add'
import preciousmetalsList from '../pages/preciousmetals/list'
import preciousmetalsDetail from '../pages/preciousmetals/detail'
import preciousmetalsAdd from '../pages/preciousmetals/add'
import legaltermsList from '../pages/legalterms/list'
import legaltermsDetail from '../pages/legalterms/detail'
import legaltermsAdd from '../pages/legalterms/add'
import leaveapplicationList from '../pages/leaveapplication/list'
import leaveapplicationDetail from '../pages/leaveapplication/detail'
import leaveapplicationAdd from '../pages/leaveapplication/add'
import workscheduleList from '../pages/workschedule/list'
import workscheduleDetail from '../pages/workschedule/detail'
import workscheduleAdd from '../pages/workschedule/add'
import notificationinformationList from '../pages/notificationinformation/list'
import notificationinformationDetail from '../pages/notificationinformation/detail'
import notificationinformationAdd from '../pages/notificationinformation/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'bankemployee',
					component: bankemployeeList
				},
				{
					path: 'bankemployeeDetail',
					component: bankemployeeDetail
				},
				{
					path: 'bankemployeeAdd',
					component: bankemployeeAdd
				},
				{
					path: 'customer',
					component: customerList
				},
				{
					path: 'customerDetail',
					component: customerDetail
				},
				{
					path: 'customerAdd',
					component: customerAdd
				},
				{
					path: 'productclassification',
					component: productclassificationList
				},
				{
					path: 'productclassificationDetail',
					component: productclassificationDetail
				},
				{
					path: 'productclassificationAdd',
					component: productclassificationAdd
				},
				{
					path: 'loanmethods',
					component: loanmethodsList
				},
				{
					path: 'loanmethodsDetail',
					component: loanmethodsDetail
				},
				{
					path: 'loanmethodsAdd',
					component: loanmethodsAdd
				},
				{
					path: 'loanproducts',
					component: loanproductsList
				},
				{
					path: 'loanproductsDetail',
					component: loanproductsDetail
				},
				{
					path: 'loanproductsAdd',
					component: loanproductsAdd
				},
				{
					path: 'loanapplication',
					component: loanapplicationList
				},
				{
					path: 'loanapplicationDetail',
					component: loanapplicationDetail
				},
				{
					path: 'loanapplicationAdd',
					component: loanapplicationAdd
				},
				{
					path: 'wealthmanagementproducts',
					component: wealthmanagementproductsList
				},
				{
					path: 'wealthmanagementproductsDetail',
					component: wealthmanagementproductsDetail
				},
				{
					path: 'wealthmanagementproductsAdd',
					component: wealthmanagementproductsAdd
				},
				{
					path: 'bankoutlet',
					component: bankoutletList
				},
				{
					path: 'bankoutletDetail',
					component: bankoutletDetail
				},
				{
					path: 'bankoutletAdd',
					component: bankoutletAdd
				},
				{
					path: 'preciousmetals',
					component: preciousmetalsList
				},
				{
					path: 'preciousmetalsDetail',
					component: preciousmetalsDetail
				},
				{
					path: 'preciousmetalsAdd',
					component: preciousmetalsAdd
				},
				{
					path: 'legalterms',
					component: legaltermsList
				},
				{
					path: 'legaltermsDetail',
					component: legaltermsDetail
				},
				{
					path: 'legaltermsAdd',
					component: legaltermsAdd
				},
				{
					path: 'leaveapplication',
					component: leaveapplicationList
				},
				{
					path: 'leaveapplicationDetail',
					component: leaveapplicationDetail
				},
				{
					path: 'leaveapplicationAdd',
					component: leaveapplicationAdd
				},
				{
					path: 'workschedule',
					component: workscheduleList
				},
				{
					path: 'workscheduleDetail',
					component: workscheduleDetail
				},
				{
					path: 'workscheduleAdd',
					component: workscheduleAdd
				},
				{
					path: 'notificationinformation',
					component: notificationinformationList
				},
				{
					path: 'notificationinformationDetail',
					component: notificationinformationDetail
				},
				{
					path: 'notificationinformationAdd',
					component: notificationinformationAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
