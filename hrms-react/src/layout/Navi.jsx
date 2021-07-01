import React from 'react'
import { Button, Menu, Input, Container } from 'semantic-ui-react'

export default function Navi () {
  return (
    <div className="navi">
        <Menu inverted fixed="top">
          <Container>
            <Menu.Item>
              <Button primary>Sign up</Button>
            </Menu.Item>

            <Menu.Item>
              <Button>Log-in</Button>
            </Menu.Item>
            <Menu.Item position="right">
              <Input className='icon' icon='search' placeholder='Search...' />
            </Menu.Item>
          </Container>
        </Menu>
    </div>
  );
}
