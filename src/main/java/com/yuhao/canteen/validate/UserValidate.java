package com.yuhao.canteen.validate;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, RegisterUser.class, LoginUser.class})
public class UserValidate {
}
