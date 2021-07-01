import React from 'react'
import { Menu } from 'semantic-ui-react'

export default function Sidebar () {
  return (
    <div className="sidebar">
      <Menu fluid vertical size="large">
        <Menu.Item
          name='CV'
        />
        <Menu.Item
          name='Profile'
        />
        <Menu.Item
          name='Advertisement'
        />
      </Menu>
    </div>
  );
}
