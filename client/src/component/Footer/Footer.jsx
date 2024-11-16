import { Box, Container, Typography, Link } from '@mui/material';

function Footer(){
  return(
    <Box
      sx={{
        backgroundColor: 'primary.main',
        padding: '20px 0',
        color: 'white',
        marginTop: 'auto',
        width: '100%',
      }}
    >
      <Container maxWidth="lg">
        <Box
          sx={{
            display: 'flex',
            justifyContent: 'space-between',
            flexWrap: 'wrap',
            alignItems: 'center',
          }}
        >
          <Typography variant="body1">© 2024 Your Company</Typography>

          <Box sx={{ display: 'flex', gap: 2 }}>
            <Link href="#" color="inherit" variant="body2">
              Privacy Policy
            </Link>
            <Link href="#" color="inherit" variant="body2">
              Terms of Service
            </Link>
            <Link href="#" color="inherit" variant="body2">
              Contact Us
            </Link>
          </Box>
        </Box>
      </Container>
    </Box>
  )
} 

export default Footer;