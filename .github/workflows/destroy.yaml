name: Destroy Service

on:
  workflow_dispatch:
    inputs:
      branch:
        description: 'Branch to run the workflow on'
        required: true
        default: 'main'
env:
  BRANCH_NAME: ${{ github.head_ref || github.ref_name }}
permissions:
  id-token: write   # This is required for requesting the JWT
  contents: read
jobs:
  deploy:
    name: destroy service
    runs-on: ubuntu-latest
    steps:
    - name: Checkout
      uses: actions/checkout@v3

    - name: Configure AWS credentials
      uses: aws-actions/configure-aws-credentials@v3
      with:
        role-to-assume: ${{secrets.AWS_ROLE_ARN}}
        role-session-name: samplerolesession
        aws-region: ${{secrets.AWS_REGION}}
    
    - name: Update kube config
      run: aws eks update-kubeconfig --name ${{secrets.EKS_CLUSTER_NAME}} --region ${{secrets.AWS_REGION}}

    - name: helm delete
      run: |
        cd demo-charts/demo && helm uninstall demo  --wait    
