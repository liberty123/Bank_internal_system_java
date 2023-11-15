export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["add","view","modify","del"],"menu":"Bank employees","menuJump":"table","tableName":"bankemployee"}],"menu":"Bank employeesmanage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["add","view","modify","del"],"menu":"client","menuJump":"table","tableName":"customer"}],"menu":"clientmanage"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["add","view","modify","del"],"menu":"product class","menuJump":"table","tableName":"productclassification"}],"menu":"product classmanage"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["add","view","modify","del"],"menu":"Loan method","menuJump":"table","tableName":"loanmethods"}],"menu":"Loan methodmanage"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["add","view","modify","del"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product manage"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["view","modify","del","Review"],"menu":"loan application","menuJump":"table","tableName":"loanapplication"}],"menu":"loan applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["add","view","modify","del","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product manage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["add","view","modify","del","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank networkmanage"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["add","view","modify","del"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metalmanage"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["add","view","modify","del"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisionsmanage"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["add","view","modify","del"],"menu":"Examination Notice","menuJump":"table","tableName":"examnotice"}],"menu":"Examination Noticemanage"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["view","modify","del","Review"],"menu":"Leave Application","menuJump":"table","tableName":"leaveapplication"}],"menu":"Leave Applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["view","modify","del"],"menu":"order of the day","menuJump":"table","tableName":"workschedule"}],"menu":"order of the daymanage"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["view","modify","del"],"menu":"notification information","menuJump":"table","tableName":"notificationinformation"}],"menu":"notification informationmanage"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["view","modify"],"menu":"Rotation chart management","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["add","view","modify","del"],"menu":"Notice Announcement","tableName":"news"}],"menu":"system manage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","loan application"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product module"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["view","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product module"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank network module"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["view"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metal module"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["view"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisions module"}],"hasBackLogin":"Y","hasBackRegister":"N","hasFrontLogin":"N","hasFrontRegister":"N","roleName":"administrator","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-link","buttons":["view","Review"],"menu":"loan application","menuJump":"table","tableName":"loanapplication"}],"menu":"loan applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["view"],"menu":"Examination Notice","menuJump":"table","tableName":"examnotice"}],"menu":"Examination Noticemanage"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["add","view","modify","del"],"menu":"Leave Application","menuJump":"table","tableName":"leaveapplication"}],"menu":"Leave Applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["add","view","modify","del"],"menu":"order of the day","menuJump":"table","tableName":"workschedule"}],"menu":"order of the daymanage"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["add","view","modify","del"],"menu":"notification information","menuJump":"table","tableName":"notificationinformation"}],"menu":"notification informationmanage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","loan application"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product module"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["view","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product module"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank network module"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["view"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metal module"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["view"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisions module"}],"hasBackLogin":"Y","hasBackRegister":"N","hasFrontLogin":"Y","hasFrontRegister":"N","roleName":"Bank employees","tableName":"bankemployee"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-link","buttons":["view","del"],"menu":"loan application","menuJump":"table","tableName":"loanapplication"}],"menu":"loan applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["view"],"menu":"notification information","menuJump":"table","tableName":"notificationinformation"}],"menu":"notification informationmanage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","loan application"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product module"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["view","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product module"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank network module"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["view"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metal module"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["view"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisions module"}],"hasBackLogin":"Y","hasBackRegister":"N","hasFrontLogin":"Y","hasFrontRegister":"Y","roleName":"client","tableName":"customer"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
