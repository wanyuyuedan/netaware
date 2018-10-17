import React, { PureComponent } from 'react';
import SelfImageWrapper from '../../components/SelfImageWrapper';

export default class Workplace extends PureComponent {
  render() {
    return (
    <div>
      <h1>Hello World!</h1>
      <SelfImageWrapper  src="https://os.alipayobjects.com/rmsportal/mgesTPFxodmIwpi.png"   desc="示意图"  />
    </div>
    );
  }
}