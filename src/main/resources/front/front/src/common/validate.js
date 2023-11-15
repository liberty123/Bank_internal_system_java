export default {
    isEmail2: function (s) {
          return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(s)
    },
  isEmail: function (rule, value, callback) {
    let reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的邮箱'));
    } else {
      callback()
    }
  },
  isEmailNotNull: function (rule, value, callback) {
    let reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的邮箱'));
    }else if (!value) {
      callback(new Error('Enter 邮箱'));
    } else {
      callback()
    }
  },
  isMobile2: function (s) {
        return /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/.test(s);
  },
  isMobile: function (rule, value, callback) {
    let reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter the correct phone number'));
    } else {
      callback()
    }
  },
  isMobileNotNull: function (rule, value, callback) {
    let reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter the correct phone number'));
    } else if(!value){
      callback(new Error('Enter phone码'));
    } else {
      callback()
    }
  },
  isPhone: function (rule, value, callback) {
    let reg = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter the correct phone number'));
    } else {
      callback()
    }
  },
  isPhoneNotNull: function (rule, value, callback) {
    let reg = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter the correct phone number'));
    } else if(!value) {
      callback(new Error('Enter 电话号码'));
    } else {
      callback()
    }
  },
  isURL: function (rule, value, callback) {
    let reg = /^http[s]?:\/\/.*/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter the correct URL address'));
    } else {
      callback()
    }
  },
  isURLNotNull: function (rule, value, callback) {
    let reg = /^http[s]?:\/\/.*/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter the correct URL address'));
    } else if(!value) {
      callback(new Error('Enter  address'));
    } else {
      callback()
    }
  },
  isNumber: function (rule, value, callback) {
    let reg = /(^-?[+-]?([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$)|(^$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的数字'));
    } else {
      callback()
    }
  },
  isNumberNotNull: function (rule, value, callback) {
    let reg = /(^-?[+-]?([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$)|(^$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的数字'));
    } else if(!value) {
      callback(new Error('Enter number'));
    } else {
      callback()
    }
  },
  isIntNumer: function (rule, value, callback) {
    let reg = /(^-?\d+$)|(^$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的整数'));
    } else {
      callback()
    }
  },
  isIntNumerNotNull: function (rule, value, callback) {
    let reg = /(^-?\d+$)|(^$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的整数'));
    } else if(!value) {
      callback(new Error('Enter integer'));
    } else {
      callback()
    }
  },
  isIdCard: function (rule, value, callback) {
    let reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的ID card'));
    } else {
      callback()
    }
  },
  isIdCardNotNull: function (rule, value, callback) {
    let reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的ID card'));
    } else if(!value) {
      callback(new Error('Enter ID card'));
    } else {
      callback()
    }
  }
}
